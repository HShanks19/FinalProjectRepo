import {
  Card, Button,
} from 'react-bootstrap';
import { Link } from 'react-router-dom';

const SearchResult = ({
  firstName,
  lastName,
  dateOfBirth,
  placeOfBirth,
  address,
  citizenId,
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
      <Link to={{
        pathname: `/Biography/${citizenId}`,
      }}
      >
        <Button variant="danger" className="citizen-card-button">View profile</Button>
      </Link>
    </Card>
    <br />
  </>
);

export default SearchResult;
