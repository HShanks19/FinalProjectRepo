import { BrowserRouter as Route, Router } from 'react-router-dom';
import SearchForm from './SearchForm/SearchForm';
import Footer from './Footer/Footer';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import './SearchForm/SearchForm.css';
import './Footer/Footer.css';
import redsearchText from './redsearchText.svg';
import CitizenPage from './CitizenProfilePage/CitizenProfile';

function App() {
  return (
    <>
      <div className="App">
        <img src={redsearchText} alt="Logo" style={{ height: 120, width: 900, margin: 50 }} />
        <SearchForm />
        <Router>
          <Route>
            <CitizenPage />
          </Route>
        </Router>
        <Footer />
      </div>
    </>
  );
}

export default App;
