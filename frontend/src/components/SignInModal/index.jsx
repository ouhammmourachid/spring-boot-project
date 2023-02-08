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
<div class="w-full max-w-sm p-4 bg-white border border-gray-200 rounded-xl shadow sm:p-6 md:p-8 dark:bg-colordark dark:border-gray-700">
    <form class="space-y-6" ref={signUp}>
        <h5 class="text-xl font-medium text-gray-900 dark:text-black">Sign in to shiny</h5>
        <div>
            <label for="email" class="block mb-2 text-sm font-medium text-secondary">Your email</label>
            <input type="email" name="email" id="email" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400 " placeholder="name@company.com" required/>
        </div>
        <div>
            <label for="password" class="block mb-2 text-sm font-medium text-secondary">Your password</label>
            <input type="password" name="password" id="password" placeholder="••••••••" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5 dark:bg-gray-600 dark:border-gray-500 dark:placeholder-gray-400" required/>
        </div>
        <div class="flex items-start">
            <div class="flex items-start">
                <div class="flex items-center h-5">
                    <input id="remember" type="checkbox" value="" class="w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-blue-300 dark:bg-gray-700 dark:border-gray-600 dark:focus:ring-blue-600 dark:ring-offset-gray-800 dark:focus:ring-offset-gray-800" required />
                </div>
                <label for="remember" class="ml-2 text-sm font-medium text-secondary">Remember me</label>
            </div>
            <a href="/" class="ml-auto text-sm text-blue-700 hover:underline dark:text-blue-500">Lost Password?</a>
        </div>
        <button type="submit" class="w-full text-white bg-primary hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800">Login to your account</button>
    </form>
    </div>
    </div>
    )
}