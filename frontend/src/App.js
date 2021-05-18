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
          <Route>
            <CitizenPage />
          </Route>
          <Route>
            <Biography />
            </Route>
          <Route>
            <Associates />
          </Route>
          <Route>
            <Finances />
          </Route>
          <Route>
            <Whereabouts />
          </Route>
        </Router>
      </div>
    </>
  );
}

export default App;
