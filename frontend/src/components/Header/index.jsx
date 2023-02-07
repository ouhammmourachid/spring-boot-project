import LightLogo from '../../assets/light-logo.png';
import DarkLogo from '../../assets/dark-logo.png';
import { Link } from 'react-router-dom';
import {Light} from '../icones/Light';
import { Moon } from '../icones/Moon';


function Header({darkMode,setDarkMode,setShowSignIn,setShowSignUp}){
    return(
        <nav class="flex items-center justify-between p-4 ">
            <div class="flex items-center">
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
                    <button className="bg-primary hover:bg-blue-700 text-white font-medium py-2 px-4 rounded-full"
                            onClick={()=>setShowSignUp(true)}>Sign Up</button>
                    <button className="bg-white hover:bg-gray-100 text-gray-800 font-medium py-2 px-4 rounded-full ml-4"
                            onClick={()=>setShowSignIn(true)}>Login</button>
                </div>
            </div>
        </nav>
    )
}
export default Header;