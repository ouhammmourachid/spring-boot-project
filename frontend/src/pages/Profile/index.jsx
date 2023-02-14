import { useState } from 'react';
import profile from '../../assets/profile.png';
import cv from '../../assets/cv.pdf';
import HiddenProfile from '../../components/HiddenProfile';

export default function Profile(){
    const [showMore,setShowMore] = useState(false);
    return(
    <div className="flex  flex-wrap justify-center pb-3 pt-12 min-h-screen mx-72">
        <div className="p-8 bg-zinc-100 dark:bg-purple-400 shadow mt-24 rounded-xl ">
            <div className="grid grid-cols-1 md:grid-cols-3">
                <div className="grid grid-cols-3 text-center order-last md:order-first mt-20 md:mt-0">
                </div>
                <div className="relative">
                    <div className="w-48 h-48 bg-indigo-100 mx-auto rounded-full shadow-2xl absolute inset-x-0 top-0 -mt-24 flex items-center justify-center text-indigo-500">
                        <img src={profile} alt="profile" className='h-full w-full'  />
                    </div>
                </div>
                <div className="space-x-8 flex justify-between mt-32 md:mt-0 md:justify-center">
                    <button className="text-white py-2 px-4 uppercase rounded-2xl bg-blue-400 hover:bg-blue-500 shadow hover:shadow-lg font-medium transition transform hover:-translate-y-0.5">
                        Edit
                    </button>
                </div>
            </div>
            <div className="mt-20 text-center pb-12 border-secondary border-b-4">
                <h1 className="text-4xl font-medium text-gray-700">Jessica Jones, <span class="font-light text-gray-500">27</span></h1>
                <p className="font-light text-gray-600 mt-3">Bucharest, Romania</p>
                <p className="mt-8 text-gray-500">Solution Manager - Creative Tim Officer</p>
                <p className="mt-2 text-gray-500">University of Computer Science</p>
            </div>
            <div className="mt-12 flex flex-col justify-center">
                <p className="text-gray-600 text-center font-light lg:px-16">
                An artist of considerable range, Ryan — the name taken by Melbourne-raised,
                Brooklyn-based Nick Murphy — writes, performs and records all of his own music,
                giving it a warm, intimate feel with a solid groove structure. An artist of
                considerable range.
                </p>
                {showMore &&
                    <HiddenProfile />
                }
                <button
                    className="py-2 px-4  font-medium mt-4 text-secondary"
                    onClick={()=>setShowMore(!showMore)}
                >
                   {!showMore ? "Show more":"Show less"}
                </button>
            </div>
        </div> 
    </div>
    )
}