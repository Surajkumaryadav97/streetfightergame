import {CircularProgressbar} from 'react-circular-progressbar';
import "react-circular-progressbar/dist/styles.css";

const CircularBar = (props)=>{
    const percentage = 100;
    const pathColor='red';
    return( 
        <div style={{
            transform: `rotate(${-1 * props.turns}turn)`
            
          }} >
            <CircularProgressbar styles={{ root: { height: 40 },path:{stroke:pathColor}}} value={percentage} text={`${percentage}%`} />
        </div>
    );
}

export default CircularBar;