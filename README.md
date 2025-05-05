                             Omaha Henry Doorly Zoo Animal Observations
Setup Instructions in visual studio 
Step 1: Clone the Repository
git clone https://github.com/your-repo/omaha-zoo-observations.git
cd omaha-zoo-observations

Step 2: Backend Setup (Spring Boot)
Prerequisites:
Java 17+
Maven
Spring Boot
MongoDB Database
Run the Backend:
cd backend
Mvn spring-boot:run
The backend will start at:
🔗 http://localhost:8080
Key Endpoints:
GET /api/observations → Returns all observations
POST /api/observations → Creates a new observation

Step 3: Frontend Setup (React)
Prerequisites:
Node.js 18+
npm/yarn
Modern browser(chrome/firefox/Edge)
Run the Frontend:
Front End Technology frameworks
React: Fast rendering for real-time observation updates. UI development
Vite: Lightening fast development server. Build Tool
Axios: Simplified API calls to Spring Boot. HTTP client 


cd frontend
npm install
npm run dev

The frontend will open at:
🔗 http://localhost:3000

Step 4: Verify the App
Create an Observation:
Enter an animal name (e.g., "Lion")
Select behavior (Feeding/Resting/Active)
Click "Submit"
View Observations:
The list automatically updates with new entries.
Timestamps are generated automatically.

🛠 Technical Details
Backend (Spring Boot)
Database: H2 (in-memory, resets on restart)
API Docs: http://localhost:8080/swagger-ui.html
Key Files:
ObservationController.java → API endpoints
Observation.java → Data model
Frontend (React)
Framework: React 18 + Vite
Key Features:
Auto-refreshing observation list
Form validation
Key Files:
AddObservation.jsx → Submission form
ObservationList.jsx → Display component


❓ Troubleshooting
Issue
Solution
Backend fails to start
Check Java 17+ is installed (java-version)
Frontend won’t load
Run npm install and check Node.js version
CORS errors
Ensure backend is running before frontend



## Next Steps
- Try creating sample observations with different animal behaviors  
- Explore extending the API with new endpoints 


Happy Observing! 🦁🐘


## Final Notes  
This minimal implementation demonstrates core functionality while being  
easily extensible for future zoo staff needs.  

To explore further:  
- Check the API docs at `http://localhost:8080/swagger-ui.html`  
- Review the H2 console at `http://localhost:8080/h2-console` 

