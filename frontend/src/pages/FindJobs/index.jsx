import CardJob from '../../components/CardJob';
import Location from '../../components/icones/Location';
import Arrow from '../../components/Arrow';
function FindJobs(){
    return (
    <div className="fixed  flex flex-col w-full h-full items-center dark:bg-colordark">
        <form class="flex items-center w-1/2 mt-9">   
    <label for="waht" class="sr-only">Search</label>
    <div class="relative w-full mx-3">
        <div class="absolute inset-y-0 left-0 flex items-center pl-1 pointer-events-none font-semibold">
            what
        </div>
        <input type="text" id="what" class="bg-gray-50 border border-gray-300 text-black text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-12 p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-black dark:focus:ring-blue-500 dark:focus:border-blue-500 outline-none" placeholder="Job title, Company,..."/>
    </div>
    <div class="relative w-full ">
        <div class="absolute inset-y-0 left-0 flex items-center pl-1 pointer-events-none font-semibold">
            where
        </div>
        <input type="text" id="what" class="bg-gray-50 border border-gray-300 text-black text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-14 p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-black dark:focus:ring-blue-500 dark:focus:border-blue-500 outline-none" placeholder="city or region"/>
        <div className="absolute inset-y-0 right-0 flex items-center pr-3">
            <Location />
        </div>
    </div>
    <button type="submit" class="inline-flex items-center py-2.5 px-3 ml-2 text-sm font-medium text-white bg-primary rounded-lg border border-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
        <svg aria-hidden="true" class="w-5 h-5 mr-2 -ml-1" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path></svg>Search
    </button>
    </form>
    <CardJob />
    <CardJob />
    <Arrow />
    </div>
    )
}
export default FindJobs;