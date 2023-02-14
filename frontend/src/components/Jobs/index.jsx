import CardJob from "../CardJob";
import Arrow from "../Arrow";

export default function Jobs(){
    return (
        <div className="flex flex-col items-center">
            <CardJob />
            <CardJob />
            <CardJob />
            <Arrow/>
        </div>
    )
}