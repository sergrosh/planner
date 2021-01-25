import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';

class App extends Component {
    state = {
        isLoading: true,
        families: []
    };

    async componentDidMount() {
        const response = await fetch('/api/v1/family/all');
        const body = await response.json();
        this.setState({families: body, isLoading: false});
    }

    render() {
        const {families, isLoading} = this.state;

        if (isLoading) {
            return <p>Loading...</p>;
        }
        return (
            <div className="App">
                <header className="App-header">
                    <img src={logo} className="App-logo" alt="logo"/>
                    <div className="App-intro">
                        <h2>JUG List</h2>
                        {families.map(family =>
                            <div key={family.id}>
                                {family.lastName}
                            </div>
                        )}
                    </div>
                </header>
            </div>
        );
    }
}

export default App;