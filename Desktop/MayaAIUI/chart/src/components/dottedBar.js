import React from "react";
import "./main.css";
import {
  CircularProgressbar,
  buildStyles,
  CircularProgressbarWithChildren,
} from "react-circular-progressbar";
import "react-circular-progressbar/dist/styles.css";
import RadialSeparators from "./RadialSeparators";

const DottedBar = () => {
  const percentage = 55;
  return (
    <div className="relative">
      <div className="w-28 h-28 absolute">
        <CircularProgressbarWithChildren
          value={0}
          strokeWidth={2}
          styles={buildStyles({
            strokeLinecap: "butt",
            pathColor: "inherited",
          })}
        >
          <RadialSeparators
            count={5}
            flag={true}
            style={{
              background: "#fff",
              width: "5px",
              // This needs to be equal to props.strokeWidth
              height: `${20}%`,
            }}
          />
        </CircularProgressbarWithChildren>
      </div>
      <div className="w-28 h-28">
        <CircularProgressbarWithChildren
          value={percentage}
          text={`${percentage}%`}
          strokeWidth={2}
          styles={buildStyles({
            strokeLinecap: "butt",
            pathColor: 'orange'
          })}
        >
          <RadialSeparators
            count={12}
            flag={false}
            style={{
              background: "#fff",
              width: "5px",
              // This needs to be equal to props.strokeWidth
              height: `${20}%`,
            }}
          />
        </CircularProgressbarWithChildren>
      </div>
    </div>
  );
};
export default DottedBar;
