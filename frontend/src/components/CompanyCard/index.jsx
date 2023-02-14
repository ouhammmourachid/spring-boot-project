import profile from '../../assets/profile.jpg';
import Star from '../icones/Star';
export default function CompanyCard(){
    return(
        <div className="flex items-center  bg-white rounded-lg shadow-lg py-3 px-2 w-1/4 h-1/6 m-4">
        <img src={profile} alt="App Logo" className="w-12 h-12 mx-auto ml-2  mr-5 rounded-xl" />
        <div>
            <h3 className="text-md font-medium text-center">App Name</h3>
            <div className="flex items-center justify-center mt-3">
                <span className="text-yellow-500">
                <Star />
                </span>
                <span className="text-yellow-500">
                <Star />
                </span>
                <span className="text-yellow-500">
                <Star />
                </span>
                <Star />
                <Star />
            </div>
        </div>
        
    </div>
    )
}