import React, { useState, useEffect } from "react";

const Study = () => {
  // Store the user's input, default to 25 mins
  const [inputMinutes, setInputMinutes] = useState(25);

  // Store countdown timer
  const [time, setTime] = useState(25 * 60); // Converted to seconds

  // Track if the timer is running
  const [isRunning, setIsRunning] = useState(false);

  // Determine if the timer has been started
  const [hasStarted, setHasStarted] = useState(false);

  // useEffect when 'isRunning' or 'time' changes
  useEffect(() => {
    let timer;

    //If timer is running and there's time left, count down the seconds
    if (isRunning && time > 0) {
      timer = setInterval(() => {
        setTime((prev) => prev - 1);
      }, 1000);
    } else {
      // If paused or finished, clear the timer
      clearInterval(timer);
    }
    // Cleanup interval when component unmounts or state changes
    return () => clearInterval(timer);
  }, [isRunning, time]);

  // Helper function to format seconds into mm:ss format
  const formatTime = (seconds) => {
    const mins = Math.floor(seconds / 60);
    const secs = seconds % 60;
    return `${String(mins).padStart(2, "0")}:${String(secs).padStart(2, "0")}`;
  };

  // Start button handler
  const handleStart = () => {
    // Only set time if this is the first time starting
    if (!hasStarted) {
      setTime(inputMinutes * 60); // Convert mins to secs
      setHasStarted(true);
    }
    setIsRunning(true); // Timer start
  };

  // Reset button handler
  const handleReset = () => {
    setIsRunning(false); // Stop timer
    setHasStarted(false); // Show input
    setTime(inputMinutes * 60); // Reset time
  };

  return (
    <div className="flex flex-col items-center justify-center min-h-screen text-white p-4">
      {/* Page Title */}
      <h1 className="text-5xl font-bold mb-6">Study</h1>

      {/* Input for minutes shown before timer starts */}
      {!hasStarted && (
        <div className="mb-8">
          <label className="block text-lg mb-2">
            Set study time (minutes):
          </label>
          <input
            type="number"
            min="1"
            value={inputMinutes}
            onChange={(e) => setInputMinutes(Number(e.target.value))}
            className="p-2 rounded-md text-black w-24 text-center"
          />
        </div>
      )}

      {/* Display the countdown*/}
      <div className="text-pink-500 text-[8rem] font-extrabold font-mono tracking-widest mb-12 border-4 border-pink-500">
        {formatTime(time)}
      </div>

      {/* Timer Controls */}
      <div className="flex gap-4">
        <button
          onClick={handleStart}
          className="px-8 py-3 bg-green-600 hover:bg-green-500 rounded-xl text-xl font-semibold"
        >
          Start
        </button>

        <button
          onClick={() => setIsRunning(false)}
          className="px-8 py-3 bg-yellow-500 hover:bg-yellow-400 rounded-xl text-xl font-semibold"
        >
          Pause
        </button>

        <button
          onClick={handleReset}
          className="px-8 py-3 bg-red-600 hover:bg-red-500 rounded-xl text-xl font-semibold"
        >
          Reset
        </button>
      </div>
    </div>
  );
};

export default Study;
