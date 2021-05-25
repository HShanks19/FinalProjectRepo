import axios from 'axios';
import { useState } from 'react';
import { Modal, Button } from 'react-bootstrap';
import 'bootstrap/dist/css/bootstrap.css';

const Colleagues = ({ data }) => {
  const searchValue = { personName: `${data.personName}`, dateofBirth: `${data.dateOfBirth}` };
  const [show, setShow] = useState(0);
  const [personNameM, setPersonNameM] = useState('');
  const [homeAddressM, setHomeAddressM] = useState('');
  const [dOBM, setDateOfBirthM] = useState('');
  const closeModal = () => setShow(0);
  const makeRequest = () => {
    axios.post('http://54.74.11.52:5001/getAllBusinessAddressInformation/', searchValue)
      .then((response) => {
        const ModalData = response.data;
        setShow(ModalData.length);
        setPersonNameM(ModalData[0].personName);
        setDateOfBirthM(ModalData[0].dateOfBirth);
        setHomeAddressM(ModalData[0].homeAddress);
      })
      .catch((err) => console.log(err));
  };
  const handleChange = () => {
    makeRequest();
  };
  return (
    <>
      <tr>
        <th scope="row">{data.personName}</th>
        <td>{data.dateOfBirth}</td>
        <div>
          <Button type="button" className="btn btn-danger btn-block" onClick={handleChange}>View Profile</Button>
        </div>
      </tr>
      <>
        <Modal show={show}>
          <Modal.Header>
            <Modal.Title>Colleague Information</Modal.Title>
          </Modal.Header>
          <Modal.Body>
            <h4>
              Citizen Name:
              {' '}
              {personNameM}
            </h4>
            <h5>
              Date of Birth:
              {' '}
              {dOBM}
            </h5>
            <h5>
              Address:
              {' '}
              {homeAddressM}
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

export default Colleagues;
