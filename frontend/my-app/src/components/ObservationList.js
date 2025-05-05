import React, { useState, useEffect } from 'react';
import './ObservationList.css'; // Correct CSS import path
 import axios from 'axios';

const ObservationList = () => {
  const [observations, setObservations] = useState([]);

  useEffect(() => {
  axios.get('http://localhost:8080/api/observations')
    .then(response => setObservations(response.data))
    .catch(error => console.error('Error fetching data:', error));
  }, []);

  return (
    <div className="observation-list">
      <h2 style={{ textAlign: 'center '}}>Recent Observations</h2>
      {observations.length === 0 ? (
        <p className="empty-message">No observations recorded yet.</p>
      ) : (
        <ul>
          {observations.map(obs => (
            <li key={obs.id}>
              <strong>{obs.animalName}</strong> - {obs.behavior.toLowerCase()}
              <span className="timestamp">
                {new Date(obs.timestamp).toLocaleString()}
              </span>
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default ObservationList;