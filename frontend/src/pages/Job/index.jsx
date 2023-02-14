import { useState } from "react";
import profile from '../../assets/profile.jpg';
import Accepted from "../../components/Accepted";
import Applayers from "../../components/Applayers";

export default function Job(){
    const [showApplayers,setShowApplayers] = useState(true);
    const [showAccepted,setShowAccepted] = useState(false);
    return(
    <main className="bg-gray-100 bg-opacity-25 pt-20 min-h-screen">
        <div className="lg:w-8/12 lg:mx-auto mb-8">
    <header className="flex flex-wrap items-center p-4 md:py-8">
      <div className="md:w-3/12 md:ml-16">
        <img className="w-full h-full  object-cover  border-2 border-pink-600 p-1" src={profile} alt="profile" />
      </div>
      <div className="w-8/12 md:w-7/12 ml-4">
        <div className="md:flex md:flex-wrap md:items-center mb-4">
          <h2 className="text-3xl inline-block font-light md:mr-2 mb-2 sm:mb-0">
            job title
          </h2>
          <span className="inline-block fas fa-certificate fa-lg text-blue-500 relative mr-6  text-xl transform -translate-y-2" aria-hidden="true">
            <i className="fas fa-check text-white text-xs absolute inset-x-0 ml-1 mt-px"></i>
          </span>
          <div className="bg-blue-500 px-2 py-1  text-white font-semibold text-sm rounded text-center sm:inline-block block">edit</div>
        </div>
        <ul className="hidden md:flex space-x-8 mb-4">
          <li  >
            <span className="font-semibold"> country</span>
          </li>
        </ul>
        <div className="hidden md:block">
          <h1 className="font-semibold">type of industry</h1>
          <span className="bioclass">adrress </span>
          <h3 className="bioclass">0659190626</h3>
          <p>ByteWebster is a web development and coding blog website. Where we provide professional web projects🌍</p>
          <span><strong>pdf file</strong></span>
        </div>
      </div>
    </header>
    <div>

      <ul className="flex items-center justify-around md:justify-center space-x-12 uppercase tracking-widest font-semibold text-xs text-gray-600 border-t">
        <li >
        <button type="button" 
        onClick={()=>{
            setShowApplayers(true);
            setShowAccepted(false)}} className="inline-block p-3 text-gray-900 bg-white border-none focus:outline-none  focus:underline  font-medium  dark:text-secondary text-lg px-5 py-2.5 mr-2 mb-2 dark:bg-colordark dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 hover:underline">applayers</button>
        </li>
        <li>
        <button type="button" 
        onClick={()=>{
            setShowAccepted(true);
            setShowApplayers(false)}} className="inline-block p-3 text-gray-900 bg-white border-none focus:outline-none  focus:underline  font-medium  dark:text-secondary text-lg px-5 py-2.5 mr-2 mb-2 dark:bg-colordark dark:border-gray-600 dark:hover:bg-gray-700 dark:hover:border-gray-600 hover:underline">accepted</button>
        </li>
      </ul>

      <div className="flex flex-wrap justify-center">
        {showApplayers && <Applayers />}
        {showAccepted && <Accepted />}
      </div>
    </div>
  </div>
</main>
    )
}