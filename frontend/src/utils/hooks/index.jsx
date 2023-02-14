import { useEffect, useState } from "react";

export function useFeachJobs(){
    const [isLoading,setIsLoading] = useState(true);
    const [data,setData] = useState({});

    useEffect(()=>{
        var requestOptions = {
            method: 'GET',
            redirect: 'follow'
          };
          
          fetch("/job", requestOptions)
            .then(response => response.text())
            .then(result => console.log(result))
            .catch(error => console.log('error', error));
    },[])
    return {isLoading,data}
}