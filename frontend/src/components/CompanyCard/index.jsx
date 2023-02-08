import profile from '../../assets/profile.jpg';
import Star from '../icones/Star';
export default function CompanyCard(){
    return(
        <div className="flex items-center  bg-white rounded-lg shadow-lg py-3 px-2 w-1/4 h-1/6 m-4">
        <img src={profile} alt="App Logo" className="w-16 h-16 mx-auto ml-2  mr-5 rounded-xl" />
        <div>
            <h3 class="text-md font-medium text-center">App Name</h3>
            <div class="flex items-center justify-center mt-6">
                <span class="text-yellow-500">
                <Star />
                </span>
                <span class="text-yellow-500">
                <Star />
                </span>
                <span class="text-yellow-500">
                <Star />
                </span>
                <Star />
                <Star />
            </div>
        </div>
        
    </div>
    )
}