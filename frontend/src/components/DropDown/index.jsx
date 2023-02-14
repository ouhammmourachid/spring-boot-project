import { Link } from "react-router-dom";

export default function DropDown(){
    return(
    <div  className="fixed bg-white divide-y divide-gray-100 rounded-lg shadow w-44 dark:bg-gray-700 dark:divide-gray-600 -ml-32">
        <div className="px-4 py-3 text-sm">
            <div>Bonnie Green</div>
            <div className="font-medium truncate">name@flowbite.com</div>
        </div>
        <ul className="py-2 text-sm text-gray-700 dark:text-gray-200">
            <li>
                <Link to='profile'  className="block px-4 py-2 ">profile</Link>
            </li>
            <li>
                <Link to='profile/edit'  className="block px-4 py-2 600 ">Edit profile</Link>
            </li>
        </ul>
        <div className="py-2">
            <Link to='signout'  className="block px-4 py-2 text-sm text-gray-700">Sign out</Link>
        </div>
</div>
    )
}