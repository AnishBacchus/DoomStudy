import React from "react";
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

import Home from "./pages/Home";
import Study from "./pages/Study";

function App() {
  return (
    // Set background color, height, and layout style
    <div
      style={{
        background:
          "radial-gradient(circle at center, #F0FFF0 60%, #FEFEFA 150%)",
        minHeight: "100vh",
        padding: "50px",
        textAlign: "center",
        margin: 0,
        color: "white",
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
