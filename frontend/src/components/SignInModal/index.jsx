import React, { useEffect,useRef} from 'react';
import {Email} from '../icones/Email';
import {Key} from '../icones/Key';

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
        <div className='bg-slate-300 dark:bg-primary w-96 h-96 rounded-xl p-5'
                ref={signUp}>
            <h2 className='text-lg text-bold border-b-2 m-6'>
                Job Search & Posting Portal: Sign In
            </h2>
            <form>
                <div className='flex m-6'>
                    <label className='mx-3 mt-1'>
                        <Email />
                    </label>
                    <input type="text" placeholder='Email ' className='rounded-md w-60 p-1 outline-none'/>
                </div>
                <div className='flex m-6'>
                    <label className='mx-3 mt-1'>
                        <Key/>
                    </label>
                    <input type="password" placeholder='password' className='rounded-md w-55 p-1 outline-none'/>
                </div>
                <div className='flex m-6 ml-16'>
                    <input type="checkbox" value="true" />
                    <p className='text-md font-semibold ml-3'>Remamber me ?</p>
                </div>
                <button className='flex m-12 bg-primary dark:bg-white rounded-3xl hover:shadow-md p-1 ml-32 px-4 py-2'> Sign In</button>
            </form>
        </div>
    </div>
    )
}