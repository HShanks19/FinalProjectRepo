import {
  Card, Button,
} from 'react-bootstrap';

const SearchResult = ({
  firstName,
  lastName,
  dateOfBirth,
  placeOfBirth,
  address,
}) => (
  <>
    <Card className="search-card">
      <b className="search-card-heading">
        {firstName}
        {' '}
        {lastName}
      </b>
      <div className="search-card-subcontainer">
        <p className="search-card-subtext">
          Date of birth:
          {' '}
          <b>{dateOfBirth}</b>
        </p>
        <p>
          Place of birth:
          {' '}
          <b>{placeOfBirth}</b>
        </p>
        <p>
          Address:
          {' '}
          <b>{address}</b>
        </p>
      </div>
      <Button variant="danger" className="citizen-card-button">View profile</Button>
    </Card>
    <br />
  </>
);

export default SearchResult;
