import LightLogo from '../../assets/light-logo.png';
import DarkLogo from '../../assets/dark-logo.png';
import { Link } from 'react-router-dom';
import {Light} from '../icones/Light';
import { Moon } from '../icones/Moon';
import { useState,useEffect,useRef } from 'react';
import profile from'../../assets/profile.jpg';
import DropDown from '../DropDown';

function Header({darkMode,setDarkMode,setShowSignIn,setShowSignUp}){
    const logedIn = true;
    const [showMenu,setShowMenu] = useState(false);
    let menuRef = useRef();

  useEffect(() => {
    let handler = (e)=>{
      if(!menuRef.current.contains(e.target)){
        setShowMenu(false);
        console.log(menuRef.current);
      }      
    };
    document.addEventListener("mousedown", handler);
    return() =>{
      document.removeEventListener("mousedown", handler);
    }
    });
    return(
        <nav className="fixed w-full z-20 top-0 bg-white dark:bg-colordark left-0 shadow-md h-18">
            <div className=' flex items-center justify-between p-2'>
                <div className="flex items-center">
                <Link to='/'>
                    <img src={ !darkMode ? DarkLogo :LightLogo } alt="logo shiny" className='w-32'/>
                </Link>
            </div>
            <div className="flex items-center text-gray">
                <div className="flex items-center">
                    <Link to="/find-jobs" className="mr-4 font-semibold hover:underline">find jobs</Link>
                    <Link to="/company-review" className="mr-4 font-semibold hover:underline">Company reviews</Link>
                </div>
                <div className="flex items-center select-none">
                    <div className='mr-4 ml-6'onClick={()=>setDarkMode(!darkMode)}>
                        {darkMode ? <Moon /> : <Light />}
                    </div>
                    {!logedIn ?
                    <div>
                        <button className="bg-primary hover:bg-blue-700 text-white font-medium py-2 px-4 rounded-full"  onClick={()=>setShowSignUp(true)}>Sign Up</button>
                        <button className="bg-white hover:bg-gray-100 text-gray-800 font-medium py-2 px-4 rounded-full ml-4"  onClick={()=>setShowSignIn(true)}>Login</button>
                    </div>
                    :
                    <div ref={menuRef}>
                        <button onClick={()=>setShowMenu(!showMenu)}>
                            <img src={profile} alt="profile" className='rounded-full w-10 mr-3'/>
                        </button>
                        {showMenu&&
                        <div >
                            <div class="relative">
                                <div class="absolute -m-1 ml-1 w-8 h-8 rounded-b-full rounded-l-full -rotate-45 bg-white"></div>
                            </div>
                            <DropDown />
                        </div>
                        }
                    </div>
                    }
                </div>
            </div>
            </div>
            
        </nav>
    )
}
export default Header;