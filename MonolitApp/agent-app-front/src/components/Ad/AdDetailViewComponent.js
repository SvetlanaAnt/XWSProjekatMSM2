import React from 'react';
import { Container, Row, Col, Button, Card, Carousel } from 'react-bootstrap'
import ListGroup from 'react-bootstrap/ListGroup'

const AdDetailViewComponent = (props) => {

    var androidFlag = props.ad.androidFlag;
    var disable = false;

    if (androidFlag === false) {
        androidFlag = "Ne"
    } else {
        androidFlag = "Da"
    }


    if (props.token === null) {
        disable = true;
    }


    var averageGrade = 0;
    if(props.ad.ratingNum === 0){
        averageGrade = 0;
    }else{
        averageGrade = props.ad.ratingNum / props.ad.ratingCnt;
    }



    return (


        <>
            <br />
            <Card
                border="secondary"
            >
                <Card.Body>
                    <Card.Title as="h4">{props.ad.name}</Card.Title>
                    <Row>
                        <Col md={5}>
                            <Card.Img src={`data:image/jpeg;base64,${props.ad.coverPhoto}`} />

                            {/* <Carousel>
                                    <Carousel.Item>
                                        <img
                                            className="d-block w-100"
                                            src="img/rent1.png"
                                            alt="First slide"
                                        />
                                        <Carousel.Caption>
                                            <h3>Dobro dosli na rent a car!</h3>
                                        </Carousel.Caption>
                                    </Carousel.Item>
                                </Carousel> */}
                            <>
                                <br />

                            </>
                            <ListGroup variant="flush">
                                <ListGroup.Item>Datum objavljivanja: {props.handleDateFormat(props.ad.publishedDate)}</ListGroup.Item>
                                <ListGroup.Item>Oglas objavio: {props.ad.publisherUserFirstName} {props.ad.publisherUserLastName} </ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>
                            </ListGroup>
                        </Col>
                        <Col >
                            <ListGroup variant="flush">
                                <ListGroup.Item>Proizvodjac: {props.ad.carManufacturer}</ListGroup.Item>
                                <ListGroup.Item>Model: {props.ad.carModel}</ListGroup.Item>
                                <ListGroup.Item>Tip: {props.ad.carType}</ListGroup.Item>
                                <ListGroup.Item>Mjenjac: {props.ad.gearboxType}</ListGroup.Item>
                                <ListGroup.Item>Broj sjedista za djecu:  {props.ad.childrenSeatNum}</ListGroup.Item>
                                <ListGroup.Item>Godiste: {props.handleYear(props.ad.year)}</ListGroup.Item>
                                <ListGroup.Item>Posjedovanje android uredjaja: {androidFlag}</ListGroup.Item>
                                <ListGroup.Item>Broj rentiranja: {props.ad.rentCnt}</ListGroup.Item>
                                <ListGroup.Item>Ocjena: {averageGrade}</ListGroup.Item>
                                <ListGroup.Item></ListGroup.Item>

                            </ListGroup>
                        </Col>
                    </Row>

                    <Row>
                        <Col>
                            {
                                disable ? null : <Button variant="outline-success" >Dodaj u korpu</Button>
                            }
                        </Col>
                    </Row>
                </Card.Body>
            </Card>
        </>

    );
}

export default AdDetailViewComponent;