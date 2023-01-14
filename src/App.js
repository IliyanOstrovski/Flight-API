import './App.css';
import {BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import FooterComponent from './components/FooterComponent';
import HeaderComponent from './components/HeaderComponent';
import ListFlightsComponent from './components/ListFlightsComponent';

function App() {
  return (
    <div>
      <Router>
      <HeaderComponent/>
      <div className = "container">  
      <ListFlightsComponent/>
      </div>
      <FooterComponent/>
      </Router>
      
    </div>
  );
}

export default App;
