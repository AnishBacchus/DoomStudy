import React from "react";

function App() {
  const palette = {
    light_grey: "#8E9AAF",
  };
  return (
    <div
      style={{
        backgroundColor: palette.light_grey,
        minHeight: "100vh",
        padding: "50px",
        textAlign: "center",
        margin: 0,
      }}
    >
      <h1> DoomStudy</h1>
      <p>For all the academic weapons who suffer from brainrot</p>
    </div>
  );
}

export default App;
