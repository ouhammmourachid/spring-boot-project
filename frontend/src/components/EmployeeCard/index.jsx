import profile from '../../assets/profile.jpg';
import Accept from '../icones/Accept';
import Deny from '../icones/Deny';

export default function EmployeeCard({active}){
    return(
        <div>
            <div className={`flex items-center  bg-white rounded-lg shadow-lg py-3 px-2 h-30 m-4 ${active ? 'w-96':'w-80'}`}>
                <img src={profile} alt="App Logo" className="w-16 h-16 mx-auto ml-2  mr-5 rounded-xl" />
                <div>
                    <h3 className="text-md font-medium text-center">rachid ohammou</h3>
                </div>
                 {active &&
                <div>
                    <button className='bg-green-200 p-2 m-3 rounded-full mr-1'>
                        <Accept />
                    </button>
                    <button className='bg-red-200 p-2 m-3 rounded-full'>
                        <Deny />
                    </button>
                </div>
                 }
                
            </div>
        </div>
    )
}