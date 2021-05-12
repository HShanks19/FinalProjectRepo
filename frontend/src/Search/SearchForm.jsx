import {
  Button, Container, Row, Col,
} from 'react-bootstrap';

const SearchForm = ({ searchValue, setSearchValue, obtainData }) => {
  const handleChange = (event) => {
    const { value } = event.target;
    setSearchValue({ ...searchValue, [event.target.name]: value });
  };

  if (!searchValue.shouldShow) {
    return null;
  }

  return (
    <>
      <Container className="container">
        <Row>
          <Col>
            <h2>Search</h2>
          </Col>
        </Row>
        <Row>
          <Col>
            <label htmlFor="first-name-input">
              First name
              <input id="first-name-input" name="firstName" value={searchValue.firstName} onChange={handleChange} className="form-control" placeholder="e.g. Mike" />
            </label>
          </Col>
          <Col>
            <label htmlFor="last-name-input">
              Last name
              <input id="last-name-input" name="lastName" value={searchValue.secondName} onChange={handleChange} className="form-control" placeholder="e.g. Smith" />
            </label>
          </Col>
        </Row>
        <br />
        <Row>
          <Col>
            <label htmlFor="date-of-birth-input">
              Date of birth
              <input id="date-of-birth-input" name="dateOfBirth" value={searchValue.dateOfBirth} onChange={handleChange} className="form-control" placeholder="DD/MM/YYYY" />
            </label>
          </Col>
          <Col>
            <label htmlFor="place-of-birth-input">
              Place of birth
              <input id="place-of-birth-input" name="placeOfBirth" value={searchValue.placeOfBirth} onChange={handleChange} className="form-control" placeholder="e.g. Manchester" />
            </label>
          </Col>
        </Row>
        <br />
        <Row>
          <label htmlFor="address-input">
            Address
            <input id="address-input" name="address" value={searchValue.address} onChange={handleChange} className="address-input form-control" placeholder="e.g. 10 Downing St, London, SW1A 2AB" />
          </label>
        </Row>
        <br />
        <Row>
          <Button variant="outline-danger" size="lg" className="wide-button" onClick={obtainData}>Search</Button>
        </Row>
      </Container>
    </>
  );
};

export default SearchForm;
