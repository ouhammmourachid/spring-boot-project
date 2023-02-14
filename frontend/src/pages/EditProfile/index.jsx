

export default function EditProfile(){
    return (
    <div className="mx-96 pt-20 dark:bg-white rounded-xl min-h-screen">
        <div className="h-full w-full">
        <h1 className="flex flex-col items-center text-secondary font-bold">Edit Job Info:</h1>
            <div className="mt-5 md:mt-0 md:col-span-2">
                <form >
        <div className="shadow overflow-hidden">
          <div className="px-4 py-5 bg-white sm:p-6">
            <div className="flex flex-wrap p-3">
              <div className="col-span-6 m-3">
                <label for="first_name" className="block text-sm font-medium text-gray-700">First name</label>
                <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="first_name" placeholder="" style={{"background-color": "#e9ecef"}}/>
              </div>
              <div className="col-span-6 m-3">
                <label for="last_name" className="block text-sm font-medium text-gray-700">Last name</label>
                <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="last_name" placeholder="" style={{"background-color": "#e9ecef"}}/>
              </div>
              <div className="col-span-6 m-3">
                <label for="email_address" className="block text-sm font-medium text-gray-700">Email address</label>
                <input type="text" className="form-control py-2 px-3 border border-gray-300 w-80 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="email_address" placeholder="" style={{"background-color": "#e9ecef"}}/>
              </div>
              <div className="col-span-6 m-3">
                <label for="phone_number" className="block text-sm font-medium text-gray-700">Phone Number</label>
                <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="phone_number" placeholder="" style={{"background-color": "#e9ecef"}}/>
              </div>
              <div className="col-span-6 m-3">
                <label for="country" className="block text-sm font-medium text-gray-700">Country / Region</label>
                <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="country" placeholder="" style={{"background-color": "#e9ecef"}}/>
              </div>
              <div className="col-span-6 m-3">
                <label for="city_or_state" className="block text-sm font-medium text-gray-700">City / State</label>
                <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="city_or_state" placeholder="" style={{"background-color": "#e9ecef"}}/>
              </div>
              <div className="col-span-6 m-3">
                <label for="job" className="block text-sm font-medium text-gray-700">Job</label>
                <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="job" placeholder="" style={{"background-color": "#e9ecef"}}/>
              </div>
              <div className="col-span-6 m-3">
                <label for="company" className="block text-sm font-medium text-gray-700">Company</label>
                <input type="text" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="company" placeholder="" style={{"background-color": "#e9ecef"}}/>
              </div>
              <div className="col-span-6 m-3">
                <label for="dob" className="block text-sm font-medium text-gray-700">Date of birth</label>
                <input type="date" className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500" id="dob" placeholder="" style={{"background-color": "#e9ecef"}}/>
              </div>
              <div className="col-span-6 m-3">
                <label className='block text-sm font-medium text-gray-700' for="headline">Headline</label>
                <textarea className="form-control py-2 px-3 border border-gray-300 bg-white rounded-md shadow-sm focus:outline-none focus:ring-indigo-500 focus:border-indigo-500 w-96" id="headline" rows="3" placeholder='Write your bio here e.g your hobbies, interests ETC' style={{"background-color": "#e9ecef"}}></textarea>
              </div>
              
              <div className="m-3 flex justify-center px-6 pt-5 pb-6 border-2 border-gray-300 border-dashed rounded-md w-96">
                <div className="space-y-1 text-center">
                  <svg className="mx-auto h-12 w-12 text-gray-400" stroke="currentColor" fill="none" viewBox="0 0 48 48" aria-hidden="True">
                    <path d="M28 8H12a4 4 0 00-4 4v20m32-12v8m0 0v8a4 4 0 01-4 4H12a4 4 0 01-4-4v-4m32-4l-3.172-3.172a4 4 0 00-5.656 0L28 28M8 32l9.172-9.172a4 4 0 015.656 0L28 28m0 0l4 4m4-24h8m-4-4v8m-12 4h.02" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                  </svg>
                  <div className="flex text-sm text-gray-600">
                    <label for="file-upload" className="relative cursor-pointer bg-white rounded-md font-medium text-indigo-600 hover:text-indigo-500 focus-within:outline-none focus-within:ring-2 focus-within:ring-offset-2 focus-within:ring-indigo-500">
                      <span>Upload an image</span>
                      <input id="file-upload" name="file-upload" type="file" className="sr-only" />
                    </label>
                    <p className="pl-1">or drag and drop</p>
                  </div>
                  <p class="text-xs text-gray-500">
                    PNG, JPG, GIF up to 10MB
                  </p>
                </div>
              </div>

              <div className="m-3 flex justify-center px-6 pt-5 pb-6 border-2 border-gray-300 border-dashed rounded-md w-96">
                <div className="space-y-1 text-center">
                  <svg className="mx-auto h-12 w-12 text-gray-400" stroke="currentColor" fill="none" viewBox="0 0 48 48" aria-hidden="True">
                    <path d="M28 8H12a4 4 0 00-4 4v20m32-12v8m0 0v8a4 4 0 01-4 4H12a4 4 0 01-4-4v-4m32-4l-3.172-3.172a4 4 0 00-5.656 0L28 28M8 32l9.172-9.172a4 4 0 015.656 0L28 28m0 0l4 4m4-24h8m-4-4v8m-12 4h.02" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" />
                  </svg>
                  <div className="flex text-sm text-gray-600">
                    <label for="file-upload" className="relative cursor-pointer bg-white rounded-md font-medium text-indigo-600 hover:text-indigo-500 focus-within:outline-none focus-within:ring-2 focus-within:ring-offset-2 focus-within:ring-indigo-500">
                      <span>Upload a file</span>
                      <input id="file-upload" name="file-upload" type="file" className="sr-only" />
                    </label>
                    <p className="pl-1">or drag and drop</p>
                  </div>
                  <p class="text-xs text-gray-500">
                    pdf up to 10MB
                  </p>
                </div>
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
    </div>
  </div>
</div>
    )
}