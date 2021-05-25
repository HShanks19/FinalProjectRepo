import axios from 'axios';
import { useState } from 'react';
import { Modal, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.css';

const Household = ({ data }) => {
  const searchValue = { forenames: `${data.forenames}`, surname: `${data.surname}`, dateOfBirth: `${data.dateOfBirth}` };
  const [show, setShow] = useState(0);
  const [forenameM, setForenamesM] = useState('');
  const [surnameM, setSurnameM] = useState('');
  const [dOB, setDateOfBirthM] = useState('');
  const [pOB, setPlaceOfBirthM] = useState('');
  const closeModal = () => setShow(0);
  const makeRequest = () => {
    axios.post('http://54.74.11.52:5001/getMatchingCitizens/', searchValue)
      .then((response) => {
        const ModalData = response.data;
        console.log(ModalData);
        setShow(ModalData.length);
        console.log(ModalData.length);
        setForenamesM(ModalData[0].forenames);
        console.log(ModalData[0].forenames);
        setSurnameM(ModalData[0].surname);
        setDateOfBirthM(ModalData[0].dateOfBirth);
        setPlaceOfBirthM(ModalData[0].placeOfBirth);
      })
      .catch((err) => console.log(err));
  };
  const handleChange = () => {
    makeRequest();
  };
  const fullName = `${data.forenames}  ${data.surname}`;
  return (
    <>
      <tr>
        <th scope="row">{ fullName }</th>
        <td>{data.dateOfBirth}</td>
        <button type="button" onClick={handleChange}>View Profile</button>
      </tr>
      <>
        <Modal show={show}>
          <Modal.Header>
            <Modal.Title>Household Member</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <h4>
              Citizen Name:
              {' '}
              {forenameM}
              {' '}
              {surnameM}
            </h4>
            <h5>
              Date of Birth:
              {' '}
              {dOB}
            </h5>
            <h5>
              Place of Birth:
              {' '}
              {pOB}
            </h5>
          </Modal.Body>
          <Modal.Footer>
            <Button variant="secondary" onClick={closeModal}>Close Modal</Button>
          </Modal.Footer>
        </Modal>
      </>
    </>
  );
};

export default Household;
