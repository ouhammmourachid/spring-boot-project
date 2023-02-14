import Image from "../../components/icones/Image";
import Pdf from "../../components/icones/Pdf";

export default function EditJob(){
    return(
        <form className="flex flex-row min-h-screen justify-center items-center px-96 pt-12">
        <div className="px-4 py-5 bg-white rounded-xl">
        <h1 className="flex flex-col items-center text-secondary font-bold">Edit Job Info:</h1>
          <div className="flex flex-wrap p-3">
            <div className="col-span-6 m-3">
              <label for="first_name" className="block text-sm font-medium text-gray-700">Title </label>
              <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="first_name" style={{"background-color": "#e9ecef"}}/>
            </div>
            <div className="col-span-6 m-3">
              <label for="country" className="block text-sm font-medium text-gray-700">Country / Region</label>
              <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="country" style={{"background-color": "#e9ecef"}}/>
            </div>
            <div className="col-span-6 m-3">
              <label for="city_or_state" className="block text-sm font-medium text-gray-700">Number of Employee wanted</label>
              <input type="number" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="city_or_state" style={{"background-color": "#e9ecef"}}/>
            </div>
            <div className="col-span-6 m-3">
              <label for="job" className="block text-sm font-medium text-gray-700">Salary</label>
              <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="job"  style={{"background-color": "#e9ecef"}}/>
            </div>
            <div className="col-span-6 m-3">
              <label className='block text-sm font-medium text-gray-700' for="headline">Description</label>
              <textarea className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 w-96" id="headline" rows="3" placeholder='Write your bio here e.g your hobbies, interests ETC' style={{"background-color": "#e9ecef"}}></textarea>
            </div>
            
            <div className="m-3 flex justify-center px-6 pt-5 pb-6 border-2 border-gray-300 border-dashed rounded-md w-80">
              <div className="space-y-1 text-center">
                <Image />
                <div className="flex text-sm text-gray-600">
                  <label for="file-upload" className="relative cursor-pointer bg-white rounded-md font-medium text-indigo-600 hover:text-indigo-500 focus-within:outline-none focus-within:ring-2 focus-within:ring-offset-2 focus-within:ring-indigo-500">
                    <span>Upload an image</span>
                    <input id="file-upload" name="file-upload" type="file" className="sr-only" />
                  </label>
                  <p className="pl-1">or drag and drop</p>
                </div>
                <p className="text-xs text-gray-500">
                  PNG, JPG, GIF up to 10MB
                </p>
              </div>
            </div>

            <div className="m-3 flex justify-center px-6 pt-5 pb-6 border-2 border-gray-300 border-dashed rounded-md w-80">
              <div className="space-y-1 text-center">
                <Pdf />
                <div className="flex text-sm text-gray-600">
                  <label for="file-upload" className="relative cursor-pointer bg-white rounded-md font-medium text-indigo-600 hover:text-indigo-500 focus-within:outline-none focus-within:ring-2 focus-within:ring-offset-2 focus-within:ring-indigo-500">
                    <span>Upload a file</span>
                    <input id="file-upload" name="file-upload" type="file" className="sr-only" />
                  </label>
                  <p className="pl-1">or drag and drop</p>
                </div>
                <p className="text-xs text-gray-500">
                  pdf up to 10MB
                </p>
              </div>
            </div>
          </div>
          <div className="px-4 py-3 bg-gray-50 text-right sm:px-6 justify-center flex">
              <button className="inline-flex justify-center py-2 px-4 border border-transparent shadow-sm text-sm font-medium rounded-md text-white bg-indigo-600 hover:bg-indigo-700 focus:outline-none focus:ring-2 focus:ring-offset-2 focus:ring-indigo-500">
              Save
              </button>
          </div>
        </div>
    </form>
    )
}