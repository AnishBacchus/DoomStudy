import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Home from "./pages/Home";
import Study from "./pages/Study";

function App() {
  // Custom color pallete
  const palette = {
    light_grey: "#8E9AAF",
  };
  return (
    // Set background color, heigh, and layout style
    <div
      style={{
        backgroundColor: palette.light_grey,
        minHeight: "100vh",
        padding: "50px",
        textAlign: "center",
        margin: 0,
      }}
    >
      {/* Wrap the app in a router so we can switch pages */}
      <Router>
        {/* Define available routes */}
        <Routes>
          {/* Root path ("/") shows the homepage */}
          <Route path="/" element={<Home />} />

          {/* "/study" path shows the study timer page */}
          <Route path="/study" element={<Study />} />
        </Routes>
      </Router>
    </div>
  );
}

export default App;
