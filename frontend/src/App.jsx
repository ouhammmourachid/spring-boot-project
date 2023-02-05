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
                    
                    <Route path="*" element={<Error />} />
                </Routes>
                <SignUpModal visible={showSignUp} setShowModel={setShowSignUp}/>
                <SignInModal visible={showSignIn} setShowModel={setShowSignIn} />
            </Router>
        </React.StrictMode>
        </div>
    </div>
    )
}

export default App;