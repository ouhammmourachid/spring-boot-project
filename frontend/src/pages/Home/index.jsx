import HomeIllustration from '../../assets/home-illustration.svg'


function Home(){
    return(
        <div className='flex flex-row justify-center py-32  space-x-6 w-full h-full'>
            <div className='flex flex-col justify-center'>
                <h2 className='pb-3 max-w-sm font-bold text-lg selection:bg-pink-400'>
                Welcome to our job search and job posting platform! Whether you're an job 
                seeker or an employer, we're here to help you find your next opportunity. 
                Our goal is to make the job search and hiring process as seamless and 
                efficient as possible. Start exploring today and take the first step towards 
                your next career move.
                </h2>
            </div>
            <img src={HomeIllustration} alt=" home illustration" />
        </div>
    )
}

export default Home;