import { useState } from 'react';
import Plus from '../icones/Plus';
import Xclose from '../icones/Xclose';

export default function HiddenProfile(){
    const [showEducation,setShowEducation] = useState(false);
    const [showSkills,setShowSkills] = useState(false);
    const [showCertificate,setShowCertificate] = useState(false);
    const [showLanguage,setShowLanguage] = useState(false);
    const [showLicense,setShowLicense] = useState(false);

    return(
        <div className="flex  flex-col items-center">
            <div className="border-t-4 border-secondary my-6 w-1/2 ">
                <h1 className="text-lg font-bold mt-3 ml-12">Education</h1>
                <div className='flex flex-wrap p-3 ml-16 border-b-2 border-secondary'>
                    <h2 className='text-md font-bold mr-3'>Ensam casa</h2>
                    <h3 className='text-sm text-secondary pt-2'>AI&GI</h3>
                </div>
                <div className='flex flex-wrap p-3 ml-16 border-b-2 border-secondary'>
                    <h2 className='text-md font-bold mr-3'>Ensam casa</h2>
                    <h3 className='text-sm text-secondary pt-2'>AI&GI</h3>
                </div>
                <div className='flex flex-wrap p-3 ml-16 border-b-2 border-secondary'>
                    <h2 className='text-md font-bold mr-3'>Ensam casa</h2>
                    <h3 className='text-sm text-secondary pt-2'>AI&GI</h3>
                </div>
                { showEducation &&
                <div className='mt-3'>
                <div className='flex'>
                    <div className="col-span-6 m-3">
                        <label for="education_level" className="block text-sm font-medium text-gray-700">Education level</label>
                        <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="education_level"  style={{"background-color": "#e9ecef"}}/>
                    </div>
                    <div className="col-span-6 m-3">
                        <label for="field" className="block text-sm font-medium text-gray-700">Field</label>
                        <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="field"  style={{"background-color": "#e9ecef"}}/>
                    </div>
                </div>
                <div className="px-4 py-3 bg-gray-50 text-right justify-center flex ">
                    <button className="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 dark:bg-blue-400">
                        Save
                    </button>
                </div>
                </div>
                }
                <div className='flex flex-col items-center justify-center'>
                    <button onClick={()=>setShowEducation(!showEducation)} >
                        {showEducation? <Xclose /> :<Plus/>}
                    </button>
                </div>
            </div>
            <div className="border-t-4 border-secondary my-12 w-1/2">
                <h1 className="text-lg font-bold mt-3 ml-12">Skills</h1>
                { showSkills &&
                <div className='mt-3'>
                <div className='flex'>
                    <div className="col-span-6 m-3">
                        <label for="label" className="block text-sm font-medium text-gray-700">Name</label>
                        <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="label"  style={{"background-color": "#e9ecef"}}/>
                    </div>
                    <div className="col-span-6 m-3">
                        <label for="since" className="block text-sm font-medium text-gray-700">Since</label>
                        <input type="date" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="since" style={{"background-color": "#e9ecef"}}/>
                    </div>
                </div>
                <div className="px-4 py-3 bg-gray-50 text-right justify-center flex ">
                    <button className="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 dark:bg-blue-400">
                        Save
                    </button>
                </div>
                </div>
                }
                <div className='flex flex-col items-center justify-center'>
                    <button onClick={()=>setShowSkills(!showSkills)} >
                        {showSkills? <Xclose /> :<Plus/>}
                    </button>
                </div>
            </div>
            <div className="border-t-4 border-secondary my-12 w-1/2">
                <h1 className="text-lg font-bold mt-3 ml-12">Certificate</h1>
                { showCertificate &&
                <div className='mt-3'>
                <div className='flex flex-wrap'>
                    <div className="col-span-6 m-3">
                        <label for="label" className="block text-sm font-medium text-gray-700">name</label>
                        <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="label"  style={{"background-color": "#e9ecef"}}/>
                    </div>
                    <div className="col-span-6 m-3">
                        <label for="expiration_date" className="block text-sm font-medium text-gray-700">Expiration Date</label>
                        <input type="date" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="expiration_date" style={{"background-color": "#e9ecef"}}/>
                    </div>
                    <div className="flex items-center m-3 mt-6">
                        <input type="checkbox" className="form-checkbox" id="checkbox" />
                        <label htmlFor="checkbox" className="ml-2 block text-md font-medium text-gray-700">
                         dont expire  
                        </label>
                    </div>
                </div>
                <div className="px-4 py-3 bg-gray-50 text-right justify-center flex ">
                        <button className="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 dark:bg-blue-400">
                        Save
                        </button>
                </div>
                </div>
                }
                <div className='flex flex-col items-center justify-center'>
                    <button onClick={()=>setShowCertificate(!showCertificate)} >
                        {showCertificate? <Xclose />:<Plus />}
                    </button>
                </div>
            </div>
            <div className="border-t-4 border-secondary my-12 w-1/2">
                <h1 className="text-lg font-bold mt-3 ml-12">Language</h1>
                { showLanguage &&
                <div className='mt-3'>
                <div className='flex'>
                    <div className="col-span-6 m-3">
                        <label for="language" className="block text-sm font-medium text-gray-700">Language</label>
                        <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="language"style={{"background-color": "#e9ecef"}}/>
                    </div>
                    <div className="col-span-6 m-3">
                        <label for="level" className="block text-sm font-medium text-gray-700">level</label>
                        <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="level" style={{"background-color": "#e9ecef"}}/>
                    </div>
                    
                </div>
                <div className="px-4 py-3 bg-gray-50 text-right justify-center flex ">
                        <button className="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 dark:bg-blue-400">
                        Save
                        </button>
                </div>
                </div>
                }
                <div className='flex flex-col items-center justify-center'>
                    <button onClick={()=>setShowLanguage(!showLanguage)} >
                        {showLanguage? <Xclose />:<Plus/>}
                    </button>
                </div>
            </div>
            <div className="border-t-4 border-secondary my-12 w-1/2">
                <h1 className="text-lg font-bold mt-3 ml-12">License</h1>
                { showLicense &&
                <div className='mt-3'>
                <div className='flex flex-wrap'>
                    <div className="col-span-6 m-3">
                        <label for="label" className="block text-sm font-medium text-gray-700">name</label>
                        <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="label"  style={{"background-color": "#e9ecef"}}/>
                    </div>
                    <div className="col-span-6 m-3">
                        <label for="expiration_date" className="block text-sm font-medium text-gray-700">Expiration Date</label>
                        <input type="date" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="expiration_date" style={{"background-color": "#e9ecef"}}/>
                    </div>
                    <div className="flex items-center m-3 mt-6">
                        <input type="checkbox" className="form-checkbox" id="checkbox" />
                        <label htmlFor="checkbox" className="ml-2 block text-md font-medium text-gray-700">
                         dont expire  
                        </label>
                    </div>
                </div>
                <div className="px-4 py-3 bg-gray-50 text-right justify-center flex ">
                        <button className="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500 dark:bg-blue-400">
                        Save
                        </button>
                </div>
                </div>
                }
                <div className='flex flex-col items-center justify-center'>
                    <button onClick={()=>setShowLicense(!showLicense)}>
                        {showLicense ? <Xclose />:<Plus/>}
                    </button>
                </div>
            </div>
        </div>
    )
}