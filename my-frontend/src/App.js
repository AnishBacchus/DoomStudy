import React from "react";
import Home from "./pages/Home";

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
      {/* Create the Home component under the header*/}
      <Home />
    </div>
  );
}

export default App;
