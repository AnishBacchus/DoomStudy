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
    <div
      style={{
        minHeight: "100vh",
        padding: 40,
        color: "white",
      }}
    >
      {/* Style for animation*/}
      <style>
        {`
          @keyframes pulseGlow{
            0%{
              box-shadow: 0 0 20px rgba(59,130,246,0.6);
            }
            50%{
              box-shadow: 0 0 35px rgba(59,130,246,0.9);
            }
            100% {
              box-shadow: 0 0 20px rgba(59,130,246,0.6);
            }
          }
          .bubbleBox{
            box-shadow: 0 0 20px rgba(59,130,246,0.6);
            transition: transform 0.3s ease, box-shadow 0.3s ease;
          }
          .bubbleBox.pulsing{
            animation: pulseGlow 1.5s infinite ease-in-out;
          }
        `}
      </style>
      {/* Main Title */}
      <h1
        style={{
          fontSize: 40,
          textAlign: "center",
          marginBottom: 20,
          color: "#3b82f6", // Soft Blue Color
          textShadow: "0 0 10px #3b82f6, 0 0 20px #3b82f6", // Blue Glow
        }}
      >
        DoomStudy
      </h1>

      {/* Tagline */}
      <p
        style={{
          fontSize: 24,
          fontStyle: "italic",
          color: "#0077b6",
          textAlign: "center",
          textShadow: "0 0 6px #0077b6",
        }}
      >
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
              className="bubbleBox"
              style={{
                background: "white",
                borderRadius: 40,
                padding: 40,
                textAlign: "center",
                fontWeight: "600",
                fontSize: 24,
                color: "#0077b6",
                cursor: "pointer",
                //animation: "pulseGlow 2s infinite ease-in-out",
                //transition: "transform 0.3s ease",
              }}
              onMouseEnter={(e) => {
                e.currentTarget.classList.add("pulsing");
                e.currentTarget.style.transform = "translateY(-10px)";
              }}
              onMouseLeave={(e) => {
                e.currentTarget.classList.remove("pulsing");
                e.currentTarget.style.transform = "translateY(0px)";
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
