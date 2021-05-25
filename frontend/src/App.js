import { BrowserRouter as Router, Route } from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import Search from './Search/Search';
import './App.css';
import './Search/Search.css';
import './Footer/Footer.css';
import './CitizenProfilePage/Associates/Associates.css';
import './CitizenProfilePage/Biography/Biography.css';
import redsearchText from './redsearchText.svg';
import Biography from './CitizenProfilePage/Biography/Biography';
import Associates from './CitizenProfilePage/Associates/Associates';
import Finances from './CitizenProfilePage/FinanceHistory/Finances';
import Whereabouts from './CitizenProfilePage/Whereabouts/Whereabouts';

function App() {
  return (
    <>
      <div className="App">
        <Router>
          <img src={redsearchText} alt="Logo" style={{ height: 60, margin: 50 }} />
          <Route exact path="/">
            <Search />
          </Route>
          <Route path="/Biography/:citizenId">
            <Biography />
          </Route>
          <Route path="/Associates/:citizenId">
            <Associates />
          </Route>
          <Route path="/FinanceHistory/:citizenId">
            <Finances />
          </Route>
          <Route path="/Whereabouts/:citizenId">
            <Whereabouts />
          </Route>
        </Router>
      </div>
    </>
  );
}

export default App;
