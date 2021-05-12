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
      <p>
        Name:
        {' '}
        {firstName}
        {' '}
        {lastName}
      </p>
      <p>
        Date of birth:
        {' '}
        {dateOfBirth}
      </p>
      <p>
        Place of birth:
        {' '}
        {placeOfBirth}
      </p>
      <p>
        Address:
        {' '}
        {address}
      </p>
      <Button variant="danger" className="citizen-card-button">View profile</Button>
    </Card>
    <br />
  </>
);

export default SearchResult;
