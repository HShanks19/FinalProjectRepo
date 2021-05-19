/* eslint-disable react/jsx-no-comment-textnodes */
import { BrowserRouter as Router, Route } from 'react-router-dom';
import Search from './Search/Search';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import './Search/Search.css';
import './Footer/Footer.css';
import redsearchText from './redsearchText.svg';
import CitizenPage from './CitizenProfilePage/CitizenProfile';
import Biography from './CitizenProfilePage/Biography/Biography';
import Associates from './CitizenProfilePage/Associates/Associates';
import Finances from './CitizenProfilePage/FinanceHistory/Finances';
import Whereabouts from './CitizenProfilePage/Whereabouts/Whereabouts';

function App() {
  return (
    <>
      <div className="App">
        <Router>
          <Route exact path="/">
            <img src={redsearchText} alt="Logo" style={{ height: 60, margin: 50 }} />
            <Search />
          </Route>
          <Route exact path="/Citizen">
            <CitizenPage />
          </Route>
          <Route exact path="/Biography">
            <Biography />
          </Route>
          <Route exact path="/Associates">
            <Associates />
          </Route>
          <Route exact path="/Finances">
            <Finances />
          </Route>
          <Route exact path="/Whereabouts">
            <Whereabouts />
          </Route>
        </Router>
      </div>
    </>
  );
}

export default App;
