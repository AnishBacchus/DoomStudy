import React from "react";
import { Link } from "react-router-dom"; // Import Link for navigation

const Home = () => {
  // List of features for the bubble boxes
  const features = ["Study", "To-Do List", "Calendar", "Flashcards"];

  // Mapping each feature name to a route path
  const featureRoutes = {
    Study: "/study",
    "To-Do List": "/todo",
    Calendar: "/calendar",
    Flashcards: "/flashcards",
  };

  return (
    <div style={{ padding: 40, background: "#8E9AAF", minHeight: "100vh" }}>
      {/* Main Title */}
      <h1 style={{ textAlign: "center", marginBottom: 40, color: "#0077b6" }}>
        DoomStudy
      </h1>

      {/* Tagline */}
      <p style={{ fontSize: 24, fontStyle: "italic", color: "#0077b6" }}>
        Where Brainrot meets Brainpower
      </p>

      {/* Grid of Bubble Boxes */}
      <div
        style={{
          display: "grid",
          gridTemplateColumns: "repeat(2, 1fr)",
          gap: 20,
          maxWidth: 800,
          margin: "0 auto",
          marginTop: 40,
        }}
      >
        {/* Loop through each feature and create a styled Link bubble */}
        {features.map((feature, i) => (
          <Link
            to={featureRoutes[feature]} // Link to the correct route
            key={i}
            style={{ textDecoration: "none" }} // Remove underline on Link
          >
            <div
              style={{
                background: "white",
                borderRadius: 40,
                padding: 40,
                boxShadow: "0 8px 15px rgba(0,0,0,0.1)",
                textAlign: "center",
                fontWeight: "600",
                fontSize: 24,
                color: "#0077b6",
                cursor: "pointer",
                transition: "transform 0.3s ease, box-shadow 0.3s ease",
              }}
              onMouseEnter={(e) => {
                e.currentTarget.style.transform = "translateY(-10px)";
                e.currentTarget.style.boxShadow = "0 12px 25px rgba(0,0,0,0.2)";
              }}
              onMouseLeave={(e) => {
                e.currentTarget.style.transform = "translateY(0)";
                e.currentTarget.style.boxShadow = "0 8px 15px rgba(0,0,0,0.1)";
              }}
            >
              {feature}
            </div>
          </Link>
        ))}
      </div>
    </div>
  );
};

export default Home;
