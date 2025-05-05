import React, { useState } from 'react';
 import './AddObservation.css'; // Correct CSS import path
 import axios from 'axios';

const AddObservation = ({ onAdd }) => {
  const [animalName, setAnimalName] = useState('');
  const [behavior, setBehavior] = useState('FEEDING');
  const [message, setMessage] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();
  try {
     const response = await axios.post('http://localhost:8080/api/observations', {
       animalName,
       behavior
     });
     onAdd(response.data);
      setAnimalName('');
      setMessage({ text: 'Observation added!', type: 'success' });
   } catch (error) {
     setMessage({ text: 'Error adding observation', type: 'error' });
   }
  };

  return (
    <div className="add-observation">
      <h2>Add New Observation</h2>
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Animal Name:</label>
          <input 
            type="text" 
            value={animalName} 
            onChange={(e) => setAnimalName(e.target.value)} 
            required 
          />
        </div>
        
        <div className="form-group">
          <label>Behavior:</label>
          <select value={behavior} onChange={(e) => setBehavior(e.target.value)}>
            <option value="FEEDING">Feeding</option>
            <option value="RESTING">Resting</option>
            <option value="ACTIVE">Active</option>
          </select>
        </div>
        
        <button type="submit">Submit</button>
        
        {message && (
          <div className={`message ${message.type}`}>
            {message.text}
          </div>
        )}
      </form>
    </div>
  );
};

export default AddObservation;