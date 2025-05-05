import React, { useState } from 'react';
 import ObservationList from './components/ObservationList';
 import AddObservation from './components/AddObservation';
 import './App.css';

function App() {
  const [observations, setObservations] = useState([]);

  const handleAddObservation = (newObservation) => {
    setObservations([newObservation, ...observations]);
  };

  return (
    <div className="app">
      <h1 style={{ textAlign: 'center' }}>Omaha Zoo Animal Observations</h1>
      
      <AddObservation onAdd={handleAddObservation} />
      <ObservationList observations={observations} />
    </div>
  );
}

export default App;