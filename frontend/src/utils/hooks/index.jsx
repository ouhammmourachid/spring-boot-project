// import { useEffect, useState } from "react";

// export function useFeachJobs(){
//     const [isLoading,setIsLoading] = useState(true);
//     const [data,setData] = useState({});

//     useEffect(()=>{
//         var myHeaders = new Headers();
// myHeaders.append("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJyYWNoaWRvdWhhbW1vdUBnbWFpbC5jb20iLCJpYXQiOjE2NzY0MDExMTYsImV4cCI6MTY3NjQwMjU1Nn0.eSeJ8UD9auokiScV9_tbFjqEsCoM90VULpiWK3qF5v8");

// var requestOptions = {
//   method: 'GET',
//   headers: myHeaders,
//   redirect: 'follow'
// };

// fetch("localhost:8080/api/v1/job", requestOptions)
//   .then(response => response.text())
//   .then(result => console.log(result))
//   .catch(error => console.log('error', error));
//     },[])
//     return {isLoading,data}
// }