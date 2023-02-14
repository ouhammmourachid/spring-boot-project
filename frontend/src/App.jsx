import { useState } from "react";
import Header from './components/Header';
import React from 'react';
import { BrowserRouter as Router,Routes,Route } from 'react-router-dom';
import Home from "./pages/Home";
import SignUpModal from './components/SignUpModal'
import './index.css';
import { useEffect } from "react";
import SignInModal from './components/SignInModal';
import Error from "./components/Error";
import FindJobs from "./pages/FindJobs";
import CompanyReview from "./pages/CompanyReview";
import Profile from "./pages/Profile";
import EditProfile from "./pages/EditProfile";
import Company from "./pages/Company";
import Job from './pages/Job';
import EditJob from './pages/EditJob';
import Footer from './components/Footer';

function App(){
    const savedDarkMode = localStorage.getItem('darkMode')
    const [darkMode, setDarkMode] = useState(
            savedDarkMode ? JSON.parse(savedDarkMode) : false
        )
    useEffect(() => {
      localStorage.setItem('darkMode', JSON.stringify(darkMode))
    },[darkMode])
    const [showSignUp,setShowSignUp] =useState(false);
    const [showSignIn,setShowSignIn] =useState(false);
    return(
    <div className={darkMode ? 'dark':'light'}>
        <div className='dark:bg-colordark '>
            <React.StrictMode >
            <Router>
                <Header 
                    darkMode={darkMode} 
                    setDarkMode={setDarkMode}
                    setShowSignIn={setShowSignIn}
                    setShowSignUp={setShowSignUp}/>
                <Routes>
                    <Route path='/' element={<Home />} />
                    <Route path='find-jobs' element={<FindJobs />} />
                    <Route path='company-review' element={<CompanyReview />} />
                    <Route path='profile' element= {<Profile />} />
                    <Route path='profile/edit' element={<EditProfile />} />
                    <Route path='company' element={<Company />} />
                    <Route path='job' element={<Job />} />
                    <Route path='job/edit' element={<EditJob />} />
                    <Route path="*" element={<Error />} />
                </Routes>
                <SignUpModal visible={showSignUp} setShowModel={setShowSignUp}/>
                <SignInModal visible={showSignIn} setShowModel={setShowSignIn} />
            </Router>
            <Footer />
        </React.StrictMode>
        </div>
    </div>
    )
}

export default App;