import React, { useEffect,useRef} from 'react';


export default function SignUpModal({visible,setShowModel}){
    let signUp = useRef();
    useEffect(()=>{
        let handler =(e)=>{
            if(!signUp.current.contains(e.target)){
                setShowModel(false);
                console.log(signUp.current);
            }
        };
        document.addEventListener("mousedown",handler);
        return ()=>{
            document.addEventListener('mousedown',handler)
        }
    })
    if(!visible) return null;
    return(
        <div className='fixed inset-0 backdrop-blur-sm flex justify-center items-center'>     
        <div className="w-full max-w-sm p-4 bg-white border border-gray-200 rounded-xl shadow sm:p-6 md:p-8 dark:bg-colordark dark:border-gray-700">
            <form className="space-y-6" ref={signUp}>
                <h5 className="text-xl font-medium text-gray-900 dark:text-black">Sign up to shiny</h5>
                <div>
                    <label  className="block mb-2 text-sm font-medium text-secondary">Your email</label>
                    <input type="email" name="email"  className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 " placeholder="name@company.com" required/>
                </div>
                <div>
                    <label  className="block mb-2 text-sm font-medium text-secondary">Your password</label>
                    <input type="password" name="password" placeholder="••••••••" className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400" required/>
                </div>
                <div >
                    <label className='block mb-2 text-sm font-medium text-secondary'>
                        Type Account
                    </label>
                    <select className='rounded-md p-1 outline-none bg-slate-200'>
                        <option value="" disabled>
                            Select an option
                        </option>
                        <option value="employee">employee</option>
                        <option value="company">company</option>
                    </select>
                </div>
                <button type="submit" className="w-full text-white bg-primary hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Create an account</button>
            </form>
        </div>
    </div>
    )
}