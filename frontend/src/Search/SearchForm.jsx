import {
  Button, Container, Row, Col,
} from 'react-bootstrap';
import { useState, useEffect } from 'react';
import { ThreeDots } from '@agney/react-loading';
import Footer from '../Footer/Footer';

const SearchForm = ({
  // eslint-disable-next-line no-unused-vars
  testPostRequest, formVisible, searchValue, setSearchValue,
  initialSearchState, loading, setLoading,
}) => {
  const [userInputPrompt, setUserInputPrompt] = useState(false);

  function objectEquals(object1, object2) {
    if (JSON.stringify(object1) === JSON.stringify(object2)) {
      return true;
    }
    return false;
  }

  function searchButtonClicked() {
    if (objectEquals(searchValue, initialSearchState)) {
      console.log('need to enter some information in search form');
      setUserInputPrompt(true);
      setTimeout(() => {
        setUserInputPrompt(false);
      }, 3000);
      return;
    }
    setUserInputPrompt(false);
    testPostRequest();
    setLoading(true);
  }

  useEffect(() => {
    const listener = (event) => {
      if (event.code === 'Enter' || event.code === 'NumpadEnter') {
        searchButtonClicked();
      }
    };
    document.addEventListener('keydown', listener);
    return () => {
      document.removeEventListener('keydown', listener);
    };
  }, []);

  function handleChange(event) {
    const { value } = event.target;
    setSearchValue({ ...searchValue, [event.target.name]: value });
  }

  if (!formVisible) {
    return null;
  }

  return (
    <>
      <Container>
        <Row>
          <Col>
            <h2>Search</h2>
          </Col>
        </Row>
        <Row>
          <Col>
            <label htmlFor="first-name-input">
              First name
              <input id="first-name-input" name="forenames" onChange={handleChange} className="form-control" placeholder="e.g. Mike" />
            </label>
          </Col>
          <Col>
            <label htmlFor="last-name-input">
              Last name
              <input id="last-name-input" name="surname" onChange={handleChange} className="form-control" placeholder="e.g. Smith" />
            </label>
          </Col>
        </Row>
        <br />
        <Row>
          <Col>
            <label htmlFor="date-of-birth-input">
              Date of birth
              <input id="date-of-birth-input" name="dateOfBirth" onChange={handleChange} className="form-control" placeholder="YYYY-MM-DD" />
            </label>
          </Col>
          <Col>
            <label htmlFor="place-of-birth-input">
              Place of birth
              <input id="place-of-birth-input" name="placeOfBirth" onChange={handleChange} className="form-control" placeholder="e.g. Manchester" />
            </label>
          </Col>
        </Row>
        <br />
        <Row>
          <label htmlFor="address-input">
            Address
            <input id="address-input" name="homeAddress" onChange={handleChange} className="address-input form-control" placeholder="e.g. 10 Downing St, London, SW1A 2AB" />
          </label>
        </Row>
        <br />
        <Row>
          <Button type="submit" variant="outline-danger" size="lg" className="wide-button" onClick={searchButtonClicked}>Search</Button>
        </Row>
        <Row>
          { loading === true
        && (
          <ThreeDots className="loading-icon" />
        )}
          { userInputPrompt === true
        && (
          <p className="user-prompt-text">Please input data into the search form.</p>
        )}
        </Row>
      </Container>
      <Footer />
    </>
  );
};

export default SearchForm;
