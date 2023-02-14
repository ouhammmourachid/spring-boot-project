import Arrow from "../../components/Arrow"
import CompanyCard from "../../components/CompanyCard"

export default function CompanyReview(){
    return (
        <div className="flex flex-col w-full h-full items-center dark:bg-colordark min-h-screen pt-20">
            <div className="flex flex-col items-center ">
                <h1 className="font-bold text-secondary text-lg m-7">Top rated Company</h1>
                <div className=" flex flex-wrap w-8/12 h-1/2">
                    <CompanyCard />
                    <CompanyCard />
                    <CompanyCard />
                    <CompanyCard />
                    <CompanyCard />
                    <CompanyCard />
                    <CompanyCard />
                            
                </div>
            </div>
            <h1 className="text-secondary text-2xl font-bold">Find the companies that look like you</h1>
            <div className="flex flex-col w-full h-full items-center dark:bg-colordark">
                <form className="flex items-center w-1/2 mt-9">   
                    <label for="waht" className="sr-only">Search</label>
                    <div className="relative w-full mx-3">
                        <div className="absolute inset-y-0 left-0 flex items-center pl-1 pointer-events-none font-semibold">
                            name
                        </div>
                        <input type="text" id="what" className="bg-gray-50 border border-gray-300 text-black text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full pl-12 p-2.5  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-black dark:focus:ring-blue-500 dark:focus:border-blue-500 outline-none" placeholder="Job title, Company,..."/>
                    </div>
                    <button type="submit" className="inline-flex items-center py-2.5 px-3 ml-2 text-sm font-medium text-white bg-primary rounded-lg border border-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">
                        <svg aria-hidden="true" className="w-5 h-5 mr-2 -ml-1" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"></path></svg>Search
                    </button>
                </form>
                <div className=" flex flex-wrap w-8/12 h-1/2 m-7 ml-16">
                    <CompanyCard />
                    <CompanyCard />
                    <CompanyCard />
                    <CompanyCard />
                    <CompanyCard />
                    <CompanyCard />
                    <CompanyCard />        
                </div>
                <Arrow />     
            </div>
        </div>
        

    
    )
}