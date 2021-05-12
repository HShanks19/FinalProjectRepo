import SearchForm from './SearchForm/SearchForm';
import Footer from './Footer/Footer';
import 'bootstrap/dist/css/bootstrap.min.css';
import './App.css';
import './SearchForm/SearchForm.css';
import './Footer/Footer.css';
import redsearchText from './redsearchText.svg';

function App() {
  return (
    <>
      <div className="App">
        <img src={redsearchText} alt="Logo" style={{ height: 120, width: 900, margin: 50 }} />
        <SearchForm />
        <Footer />
      </div>
    </>
  );
}

export default App;
