import React from "react";
import _ from "lodash";
import CircularBar from "./circularbar";

function Separator(props) {
  return (
    <div
      style={{
        position: "absolute",
        // height: "100%",
        height: props.flag ? "256px" : "100%",
        transform: `rotate(${props.turns}turn)`,
      }}
    >
      {props.flag && <CircularBar turns={props.turns
       } />}
      <div style={props.style} />
    </div>
  );
}

function RadialSeparators(props) {
  const turns = props.flag ? 0.62 / props.count : 1 / props.count;
  return _.range(props.count).map((index) => (
    <Separator flag={props.flag} turns={index * turns} style={props.style} />
  ));
}

export default RadialSeparators;
