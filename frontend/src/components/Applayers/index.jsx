import EmployeeCard from "../EmployeeCard"

export default function Applayers(){
    return(
        <div className='flex flex-wrap items-center justify-center'>
            <EmployeeCard active={true}/>
            <EmployeeCard active={true}/>
            <EmployeeCard active={true}/>
            <EmployeeCard active={true}/>
            <EmployeeCard active={true}/>
            <EmployeeCard active={true}/>
            <EmployeeCard active={true}/>
            <EmployeeCard active={true}/>
            <EmployeeCard active={true}/>
        </div>
    )
}