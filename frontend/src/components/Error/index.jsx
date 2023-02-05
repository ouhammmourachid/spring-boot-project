import errorIlustration from '../../assets/404.svg'

function Error() {
    return (
       <div className="fixed  flex flex-col w-full h-full justify-center items-center dark:bg-colordark">
         <h1 className="font-bold text-4xl">Oops...</h1>
         <img src={errorIlustration} alt="4O4" className='max-w-3xl my-9'/>
         <h2 className="text-secondary text-2xl ">
            It looks like the page you're after doesn't exist
         </h2>
       </div>
    )
 }
 
 export default Error