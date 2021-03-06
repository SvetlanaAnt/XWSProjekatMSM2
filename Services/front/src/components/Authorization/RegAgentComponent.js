import React from 'react';
import { Form, Button, Row, Col, Container } from 'react-bootstrap';

const RegAgentComponent = (props) => {

    return (
        <Container>
            <Row>
                <Col md={5} xs={12}>
                    <h2 className="border-bottom">Registracija agenta</h2>
                </Col>
            </Row>
            <Row>
                <Col md={5} xs={12}>
                    <Form noValidate validated={props.validated} id="regForm" onSubmit={props.onSubmit}>
                        <Form.Row>
                            <Form.Group as={Col} md={8}>
                                <Form.Label>E-mail adresa</Form.Label>
                                <Form.Control required type="email" name="email" id="txtEmail" placeholder="E-mail" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col}>
                                <Form.Label>Ime</Form.Label>
                                <Form.Control required type="text" name="firstName" id="txtFirstName" placeholder="Ime" />
                            </Form.Group>
                            <Form.Group as={Col}>
                                <Form.Label>Prezime</Form.Label>
                                <Form.Control required type="text" name="lastName" id="txtLastName" placeholder="Prezime" />
                            </Form.Group>
                        </Form.Row>
                        <Form.Row>
                            <Form.Group as={Col}>
                                <Button variant="primary" id="btnSignUp" type="submit">
                                    Registruj
                                </Button>
                            </Form.Group>
                        </Form.Row>
                    </Form>
                </Col>
            </Row>
        </Container>
    );
}

export default RegAgentComponent;